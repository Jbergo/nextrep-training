const navToggle = document.getElementById('nav-toggle');
const navMenu   = document.getElementById('nav-menu');

if (navToggle && navMenu) {
  navToggle.addEventListener('click', () => {
    navMenu.classList.toggle('is-open');
  });

  // Cierra el menú al hacer clic en un enlace (móvil)
  navMenu.querySelectorAll('a').forEach(link => {
    link.addEventListener('click', () => {
      navMenu.classList.remove('is-open');
    });
  });
}