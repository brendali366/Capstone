package com.example.myapplication;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;





public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirebaseAuth = FirebaseAuth.getInstance();

        //sign up button
        Button SignUpButton = findViewById(R.id.sign_up_button);
        SignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        //login  button
        Button LoginButton = findViewById(R.id.login_button);
        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });


        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() != null) {
                    // User is signed in, handle accordingly
                    startActivity(new Intent(MainActivity.this, HomeScreen.class));
                    finish();
                }
            }
        };
    }

    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mAuthStateListener != null) {
            mFirebaseAuth.removeAuthStateListener(mAuthStateListener);
        }
    }


}




/*

package com.example.myapplication;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int RC_SIGN_IN = 1;

    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirebaseAuth = FirebaseAuth.getInstance();

        //sign up button
        Button SignUpButton = findViewById(R.id.sign_up_button);
        SignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startFirebaseAuthUI();
            }
        });


        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() != null) {
                    // User is signed in, handle accordingly
                    startActivity(new Intent(MainActivity.this, HomeScreen.class));
                    finish();
                }
            }
        };
    }

    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mAuthStateListener != null) {
            mFirebaseAuth.removeAuthStateListener(mAuthStateListener);
        }
    }

    private void startFirebaseAuthUI() {
        List<AuthUI.IdpConfig> providers = Arrays.asList(
                new AuthUI.IdpConfig.EmailBuilder()
                        .setRequireName(false) // Disable requirement for first and last name
                        .build());

        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setIsSmartLockEnabled(false)
                        .setAvailableProviders(providers)
                        .setLogo(R.drawable.learning_kids_logo)
                        .setTheme(R.style.CustomFirebaseUIStyle)
                        .build(),
                RC_SIGN_IN
        );
    }
}
*/


/*

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // variable for Firebase Auth
    private FirebaseAuth mFirebaseAuth;

    // declaring a const int value which we
    // will be using in Firebase auth.
    public static final int RC_SIGN_IN = 1;

    // creating an auth listener for our Firebase auth
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    // below is the list which we have created in which
    // we can add the authentication which we have to
    // display inside our app.
    List<AuthUI.IdpConfig> providers = Arrays.asList(

            // below is the line for adding
            // email and password authentication.
            new AuthUI.IdpConfig.EmailBuilder().build());

            // below line is used for adding google
            // authentication builder in our app.
            //new AuthUI.IdpConfig.GoogleBuilder().build(),

            // below line is used for adding phone
            // authentication builder in our app.
            //new AuthUI.IdpConfig.PhoneBuilder().build());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // below line is for getting instance
        // for our firebase auth
        mFirebaseAuth = FirebaseAuth.getInstance();

        // below line is used for calling auth listener
        // for our Firebase authentication.
        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                // we are calling method for on authentication state changed.
                // below line is used for getting current user which is
                // authenticated previously.
                FirebaseUser user = firebaseAuth.getCurrentUser();

                // checking if the user
                // is null or not.
                if (user != null) {
                    // if the user is already authenticated then we will
                    // redirect our user to next screen which is our home screen.
                    // we are redirecting to new screen via an intent.
                    Intent i = new Intent(MainActivity.this, HomeScreen.class);
                    startActivity(i);
                    // we are calling finish method to kill or
                    // mainactivity which is displaying our login ui.
                    finish();
                } else {
                    // this method is called when our
                    // user is not authenticated previously.
                    //startActivityForResult(
                    startActivityForResult(
                            // below line is used for getting
                            // our authentication instance.
                            AuthUI.getInstance()
                                    // below line is used to
                                    // create our sign in intent
                                    .createSignInIntentBuilder()

                                    // below line is used for adding smart
                                    // lock for our authentication.
                                    // smart lock is used to check if the user
                                    // is authentication through different devices.
                                    // currently we are disabling it.
                                    .setIsSmartLockEnabled(false)

                                    // we are adding different login providers which
                                    // we have mentioned above in our list.
                                    // we can add more providers according to our
                                    // requirement which are available in firebase.
                                    .setAvailableProviders(providers)

                                    // below line is for customizing our theme for
                                    // login screen and set logo method is used for
                                    // adding logo for our login page.
                                    .setLogo(R.drawable.learning_kids_logo).setTheme(R.style.Theme)

                                    // after setting our theme and logo
                                    // we are calling a build() method
                                    // to build our login screen.
                                    .build(),
                            // and lastly we are passing our const
                            // integer which is declared above.
                            RC_SIGN_IN
                    );
                }
            }
        };
    }

    @Override
    protected void onResume() {
        super.onResume();
        // we are calling our auth
        // listener method on app resume.
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // here we are calling remove auth
        // listener method on stop.
        mFirebaseAuth.removeAuthStateListener(mAuthStateListener);
    }
}
*/