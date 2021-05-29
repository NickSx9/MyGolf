package com.softwarepro.mygolf

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout
import com.softwarepro.mygolf.ui.settings.SettingsFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    lateinit var viewModel: MainActivityViewModel
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        //hide registerPage
        val registerPage: ConstraintLayout = findViewById(R.id.registerScreen)
        registerPage.visibility = View.GONE
        val cancelRegButton: Button = findViewById(R.id.buttonRegCancel)
        val registerSubmitButton: Button = findViewById(R.id.buttonRegSubmit)
        val firstName: TextInputLayout = findViewById(R.id.nameEntryField)
        val enteredEmail: TextInputLayout = findViewById(R.id.emailEntryField)
        val enteredPassword: TextInputLayout = findViewById(R.id.passwordEntryField)
        val confirmPassword: TextInputLayout = findViewById(R.id.confirmPasswordEntryField)
        //Login screen.
        var loginPage: ConstraintLayout = findViewById(R.id.loginScreen)
        val email : TextInputLayout = findViewById(R.id.numberOfPlayers)
        val password : TextInputLayout = findViewById(R.id.passwordInput)
        val submitButton: Button = findViewById(R.id.buttonSubmit)
        val cancelButton: Button = findViewById(R.id.buttonCancel)
        val registerButton: Button = findViewById(R.id.registerButton)

        cancelButton.setOnClickListener() {
            email.editText?.text?.clear()
            password.editText?.text?.clear()
        }
        submitButton.setOnClickListener() { view ->
            GlobalScope.launch(Dispatchers.Main) {
                viewModel.checkDetails(
                        email.editText?.text.toString(),
                        password.editText?.text.toString()
                )
                Thread.sleep(500)
                if (viewModel.authenticated) {
                    loginSuccessful(view, loginPage)
                } else {
                    Snackbar.make(view, "Login Failed, Please Try Again!", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show()
                    email.editText?.text?.clear()
                    password.editText?.text?.clear()
                }
            }
        }
        registerButton.setOnClickListener(){
            openRegistrationPage(registerPage, loginPage)
        }
        registerSubmitButton.setOnClickListener(){ view ->
         if(firstName.editText?.text.toString() != ""){
            if(enteredEmail.editText?.text.toString() != ""){
                if(enteredPassword.editText?.text.toString() != "" && confirmPassword.editText?.text.toString() != ""){
                    if(enteredPassword.editText?.text.toString() == confirmPassword.editText?.text.toString()){
                        //Register
                        var name =firstName.editText?.text.toString()
                        var email = enteredEmail.editText?.text.toString()
                        var password = enteredPassword.editText?.text.toString()
                        viewModel.registerNewDetails(name, email, password)
                        Toast.makeText(
                                applicationContext,
                                "Registration Complete",
                                Toast.LENGTH_SHORT
                        ).show()
                        firstName.editText?.text?.clear()
                        enteredEmail.editText?.text?.clear()
                        enteredPassword.editText?.text?.clear()
                        loginPage.visibility = View.VISIBLE
                        registerPage.visibility = View.GONE
                    }else{
                        Snackbar.make(
                                view,
                                "Passwords do not match, please try again!",
                                Snackbar.LENGTH_LONG
                        )
                                .setAction("Action", null).show()
                    }
                }else{
                    Snackbar.make(view, "Please enter a password and confirm", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show()
                }
            }else{
                Snackbar.make(view, "Please enter a email address", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show()
            }
         }else{
             Snackbar.make(view, "Please enter your name", Snackbar.LENGTH_LONG)
                     .setAction("Action", null).show()
         }
        }
        cancelRegButton.setOnClickListener(){
            closeRegistrationPage(loginPage, registerPage)
        }
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
    private fun checkRegistration(email: TextInputLayout, password: TextInputLayout):Boolean{
        var isRegistered = false
        if(email.editText?.text.toString() == "test" && password.editText?.text.toString() == "test")
        {
            isRegistered = true
        }
        return isRegistered
    }
    //register user.
    private fun openRegistrationPage(page: ConstraintLayout, loginPage: ConstraintLayout){
        loginPage.visibility = View.GONE
        page.visibility = View.VISIBLE
    }
    //return to login page.
    private fun closeRegistrationPage(loginPage: ConstraintLayout, regPage: ConstraintLayout){
        loginPage.visibility = View.VISIBLE
        regPage.visibility = View.GONE
    }
    //load main fragments.
    private fun loginSuccessful(view: View, loginPage: ConstraintLayout){
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Send Feedback", Snackbar.LENGTH_LONG)
                    .setAction("Compose Email") {
                        feedbackEmail()
                    }.show()
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        loginPage.visibility = View.GONE
        drawerLayout.visibility = View.VISIBLE
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
                setOf(
                        R.id.nav_home, R.id.nav_course, R.id.nav_booking, R.id.nav_score, R.id.nav_settings
                ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when ((destination as FragmentNavigator.Destination).className) {
                // Dont show
                SettingsFragment::class.qualifiedName -> {
                    fab.visibility = View.GONE

                }
                // show
                else -> {
                    fab.visibility = View.VISIBLE

                }
            }
        }

    }
    private fun feedbackEmail(){
        val emailIntent = Intent(Intent.ACTION_SEND)
        emailIntent.type = "text/plain"
        emailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("mygolfmobileapp@gmail.com"))
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Feedback")
        startActivity(emailIntent)
    }
}
