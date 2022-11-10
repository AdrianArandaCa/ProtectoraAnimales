package com.example.m8pruebaextra

import android.content.Intent
import android.os.Bundle
import android.provider.CalendarContract
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.m8pruebaextra.databinding.FragmentFeventBinding
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [fevent.newInstance] factory method to
 * create an instance of this fragment.
 */
class fevent : Fragment() {
    private lateinit var binding:FragmentFeventBinding
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentFeventBinding.inflate(inflater,container,false)
        binding.btmEnviar.setOnClickListener{
            var diaI = Integer.parseInt(binding.dataIniciDia.text.toString())
            var mesI = Integer.parseInt(binding.dataIniciMes.text.toString())
            var anyI = Integer.parseInt(binding.dataIniciAny.text.toString())
            var diaF = Integer.parseInt(binding.dataFiDia.text.toString())
            var mesF = Integer.parseInt(binding.dataFiMes.text.toString())
            var anyF = Integer.parseInt(binding.dataFiAny.text.toString())
            var ev = binding.etEvent.text.toString()
            var loc = binding.etLocalitat.text.toString()
            val inici = Calendar.getInstance()
            val final = Calendar.getInstance()
            inici.set(diaI,mesI,anyI,0,0)
            final.set(diaF,mesF,anyF,0,0)
            addEvent(ev, loc, inici.timeInMillis, final.timeInMillis)
        }
        // Inflate the layout for this fragment
        return binding.root
    }

    fun addEvent(event:String, loc:String, begin:Long, end:Long){
        val intent = Intent(Intent.ACTION_INSERT).apply {
            data = CalendarContract.Events.CONTENT_URI
            putExtra(CalendarContract.Events.TITLE, event)
            putExtra(CalendarContract.Events.EVENT_LOCATION, loc)
            putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, begin)
            putExtra(CalendarContract.EXTRA_EVENT_END_TIME, end)

        }
            startActivity(intent)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment fevent.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            fevent().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}