$(document).ready(function() {
    var linkToLogin = $('#linkToLogin');
    var linkToSubscribe = $('#linkToSubscribe');
    var loginForm = $('#login');
    var subscribeForm = $('#subscribe');
    var logo = $('.logo');
    var container = $('.container');

    linkToLogin.click(function() {
        subscribeForm.addClass('hidden');
        loginForm.removeClass('hidden');
        logo.css({'width': '500px', 'height': '210px'});
        container.css({'width': '70vw', 'height': '50vh'});
    })

    linkToSubscribe.click(function() {
        loginForm.addClass('hidden');
        subscribeForm.removeClass('hidden');
        logo.css({'width': '550px', 'height': '231px'});
        container.css({'width': '80vw', 'height': '80vh'});
    })
});
