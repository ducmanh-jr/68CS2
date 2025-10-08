const tvEmail = document.formsignin.txtEmail;
const tvPassword = document.formsignin.txtPassword;

// validate data sign in form
function validateFormData() {
    //lay ve username va password
    let email = tvEmail.value;
    let password = tvPassword.value;

    //kiem tra username va password co du lieu hay khong
    if (email == null || email.trim() == "") {
        alert('Please input email address.');
        tvEmail.focus();//dat tro chuot vao truong email
        return false;
    }else if(password == null || password.trim() == ""){
        alert('Please input your password.');
        tvPassword.focus();
        return false;
    }else if(!validateEmail(email)){
        alert('Please input a valid email address.');
        tvEmail.focus();//dat tro chuot vao truong email
        return false;
    }
    //kiem tra dinh dang chuan cua email
    if(email=='bannguyen@gmail.com' && password=='123456'){
        alert('Login success.');
        window.location = "register.html";        
    }else{
        alert('Login fail.');
    }
    return true;
    //kiem tra email dung dinh dang tenemail@domain name????

    //goi API phia may chu de kiem tra thong tin

    //Neu dang nhap thanh cong, thi dieu huong ve trang chu


    //nguoc lai thi thong bao loi cho nguoi dung

}
//check valid email
function validateEmail(email) {
    let regex = /^[a-z0-9]+@[a-z]+\.[a-z]{2,3}$/;
    let result = regex.test(email);
    return result;
 }