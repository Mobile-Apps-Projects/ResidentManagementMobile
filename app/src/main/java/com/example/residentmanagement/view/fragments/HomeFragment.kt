package com.example.residentmanagement.view.fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.residentmanagement.databinding.FragmentHomeBinding
import com.example.residentmanagement.utils.CurrencyFormatter
import com.example.residentmanagement.utils.DateFormatter
import com.example.residentmanagement.view.PaymentActivity
import com.example.residentmanagement.view.adapters.NotificationAdapter
import com.example.residentmanagement.viewmodel.InvoiceViewModel
import com.example.residentmanagement.viewmodel.NotificationsViewModel


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    //Views models
    private val invoiceViewModel: InvoiceViewModel by activityViewModels()
    private val notificationsViewModel: NotificationsViewModel by activityViewModels()

    //Adapters
    private val adapter = NotificationAdapter()

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentHomeBinding.inflate(inflater, container, false)

        //RecyclerView
        binding.notificationsList.adapter = adapter
        binding.notificationsList.layoutManager = LinearLayoutManager(activity)
        binding.notificationsList.setHasFixedSize(true)

        notificationsViewModel.notifications.observe(viewLifecycleOwner){
            if(it.size>0){
                adapter.addNotification(it.last())
                adapter.notifyItemInserted(it.lastIndex)
            }
        }

        notificationsViewModel.getNotifications()

        binding.paymentButton.setOnClickListener{
            val intent= Intent(activity, PaymentActivity::class.java)
            invoiceViewModel.debt.value?.let { it -> intent.putExtra("debt", it.total) }
            startActivity(intent)
        }

        invoiceViewModel.debt.observe(viewLifecycleOwner) {

                if (it != null) {
                    binding.totalDebtTV.text = CurrencyFormatter.formatCurrency(it.total)
                    binding.paymentDeadlineTV.text = DateFormatter.formatDate(it.date)
                    binding.pendingInvoices.text = it.pendingInvoices.toString()
                }


        }


        return binding.root

    }

    companion object {
        fun newInstance() = HomeFragment()
    }
}