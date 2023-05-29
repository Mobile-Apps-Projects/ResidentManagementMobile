package com.example.residentmanagement.view

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.residentmanagement.databinding.ActivityPaymentBinding
import com.example.residentmanagement.utils.CurrencyFormatter

class PaymentActivity : AppCompatActivity() {

    private val binding by lazy { ActivityPaymentBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val debt = intent.getIntExtra("debt", 0)
        debt?.let {
            binding.totalAmountToPay.text = CurrencyFormatter.formatCurrency(debt)
        }

        binding.totalBillRdBtn.setOnClickListener {
            binding.billValueTF.setText(debt.toString())
            binding.billValueTF.isEnabled = false
        }

        binding.otherValueRdBtn.setOnClickListener {
            binding.billValueTF.setText("")
            binding.billValueTF.isEnabled = true
        }

        binding.goToPay.setOnClickListener {
            //Validate billvalue no empty and email

            if (binding.billValueTF.text.isEmpty()) {
                binding.billValueTF.error = "Ingrese un valor"
                return@setOnClickListener
            }

            if (binding.email.text.isEmpty()) {
                binding.email.error = "Ingrese un email"
                return@setOnClickListener
            }

            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(binding.email.text).matches()) {
                binding.email.error = "Ingrese un email valido"
                return@setOnClickListener
            }

            val webView = WebView(this)
            webView.webViewClient = WebViewClient()
            webView.settings.javaScriptEnabled = true


            webView.webViewClient = object : WebViewClient() {
                override fun onPageFinished(view: WebView?, url: String?) {
                    val script = """
                javascript:(function() {
                    setFormValues(
                        '${binding.billValueTF.text}',
                        'Test PAYU',
                        'Test PAYU41',
                        '${binding.email.text}',
                    );
                })();
            """.trimIndent()
                    webView.loadUrl(script)
                }
            }

            webView.loadUrl("https://mobile-apps-projects.github.io/payment_pages/payment_form")


            val dialog = AlertDialog.Builder(this)
                .setView(webView)
                .setNegativeButton("Cerrar") { dialog, _ ->
                    dialog.dismiss()
                }
                .create()

            dialog.show()
        }











        binding.toolbar.setNavigationOnClickListener {
            finish()
        }
    }
}