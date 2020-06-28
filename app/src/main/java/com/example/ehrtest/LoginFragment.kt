package com.example.ehrtest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {
    private lateinit var clientTextView: TextView
    private lateinit var secretTextView: TextView
    private lateinit var userNameTextView: TextView
    private lateinit var passwordTextView: TextView
    var client: String? = null
    var secret: String? = null
    var username: String? = null
    var password: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //get info from any previous successful login
        client = App.prefs!!.client
        secret = App.prefs!!.secret
        username = App.prefs!!.username
        password = App.prefs!!.password
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        clientTextView = view.findViewById<TextView>(R.id.loginClientText)
        secretTextView = view.findViewById<TextView>(R.id.loginSecretText)
        userNameTextView = view.findViewById<TextView>(R.id.loginUsernameText)
        passwordTextView = view.findViewById<TextView>(R.id.loginPasswordText)

        userNameTextView.text = username

        //set the login button onClick
        view.findViewById<FloatingActionButton>(R.id.loginFab).setOnClickListener { view ->
            val clientText = clientTextView.text
            val secretText = secretTextView.text
            val usernameText = userNameTextView.text
            val passwordText = passwordTextView.text

            App.prefs!!.username = username.toString()
            findNavController().navigate(R.id.loginToScheduleAction)
            Snackbar.make(view, "Attempting login", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LoginFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LoginFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}