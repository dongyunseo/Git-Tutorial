const toggleBtn = document.querySelector('.toggleBtn');
const menu = document.querySelector('.menu');
const search = document.querySelector('.search');

toggleBtn.addEventListener('click', () => {
    menu.classList.toggle('active');
    search.classList.toggle('active');
});