package com.example.residentmanagement.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import androidx.lifecycle.MutableLiveData
import com.example.residentmanagement.model.Debt
import com.example.residentmanagement.model.Invoice
import com.google.firebase.firestore.ktx.firestore
import java.util.*

class InvoiceViewModel : ViewModel() {

    private val _debt = MutableLiveData<Debt?>()
    val debt: LiveData<Debt?> get() = _debt

    //Firebase
    private val db = Firebase.firestore

    init {
        getDebt()
    }

    private fun getDebt() {
        val invoicesRef = db.collection("apartamentos")
            .document("spqO2yAWlx9w7uPuFkMZ")
            .collection("facturas")
            .orderBy("date")

        invoicesRef.addSnapshotListener { snapshot, exception ->
            if (exception != null) {
                Log.e("InvoiceViewModel", "Error fetching invoices: $exception")
                return@addSnapshotListener
            }

            val invoices = mutableListOf<Invoice>()
            if (snapshot != null) {
                for (document in snapshot) {
                    val invoice = document.toObject(Invoice::class.java)
                    invoices.add(invoice)
                }
            }

            val debt = Debt(
                invoices.sumOf { it.valor.toInt() },
                invoices.lastOrNull()?.date ?: Date(),
                invoices.size
            )

            viewModelScope.launch(Dispatchers.Main) {
                _debt.value = debt
            }
        }
    }
}
