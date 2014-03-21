<?php


// alert('OK...');

// Create the form
$login = new JFormer('loginForm', array(
    'submitButtonText' => 'Login',
));

// Create the form page
$jFormPage1 = new JFormPage($login->id.'Page', array(
    'title' => '<p>Login Demo</p>',
));

// Create the form section
$jFormSection1 = new JFormSection($login->id.'Section', array());

// Check to see if the remember me checkbox should be checked by default

// Add components to the section
$jFormSection1->addJFormComponentArray(array(
    new JFormComponentSingleLineText('username', 'Username:', array(
        'validationOptions' => array('required', 'username'),
        'tip' => '<p>The demo login is <b>admin</b>.</p>',
    )),

    new JFormComponentSingleLineText('password', 'Password:', array(
        'type' => 'password',
        'validationOptions' => array('required', 'password'),
        'tip' => '<p>Password is 12345</p>',
    )),

    new JFormComponentMultipleChoice('rememberMe', '', 
        array(
            array('value' => 'remember', 'label' => 'Keep me logged in on this computer')
        ),
        array(
        'tip' => '<p>If a cookie is set you can have this checked by default.</p>',
        )
    ),
));

// Add the section to the page
$jFormPage1->addJFormSection($jFormSection1);

// Add the page to the form
$login->addJFormPage($jFormPage1);

// Set the function for a successful form submission
function onSubmit($formValues) {
    $formValues = $formValues->loginFormPage->loginFormSection;

    if($formValues->username == 'admin' && $formValues->password == '12345') {
        if(!empty($formValues->rememberMe)) {
            $response = array('successPageHtml' => '<p>Login Successful</p><p>We\'ll keep you logged in on this computer.</p>');
        }
        else {
            $response = array('successPageHtml' => '<p>Login Successful</p><p>We won\'t keep you logged in on this computer.</p>');
        }
    }
    else {
        $response = array('failureNoticeHtml' => 'Invalid username or password.', 'failureJs' => "$('#password').val('').focus();");
    }

    return $response;
}

// Process any request to the form
$login->processRequest();

		

?>