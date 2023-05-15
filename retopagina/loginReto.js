const passwordToggle = document.querySelector('.password-toggle');
const passwordInput = document.querySelector('#password');

passwordToggle.addEventListener('click', () => {
  const type = passwordInput.getAttribute('type') === 'password' ? 'text' : 'password';
  passwordInput.setAttribute('type', type);
  passwordToggle.querySelector('i').classList.toggle('fa-eye-slash');
});

const loginForm = document.querySelector('#login-form');
const termsCheckbox = document.querySelector('#terms');

loginForm.addEventListener('submit', (e) => {
  e.preventDefault();
  if (!termsCheckbox.checked) {
    alert('Debe aceptar los términos y condiciones de seguridad para continuar.');
  } else {
    alert('¡Inicio de sesión exitoso!')};
    loginForm.reset});
  

  