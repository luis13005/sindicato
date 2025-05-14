// Function to toggle the sidebar
function toggleSidebar() {
    const sidebar = document.getElementById('sidebar');
    const overlay = document.getElementById('overlay');
    sidebar.classList.toggle('open');
    overlay.classList.toggle('active');
}

// Function to close the sidebar
function closeSidebar() {
    const sidebar = document.getElementById('sidebar');
    const overlay = document.getElementById('overlay');
    sidebar.classList.remove('open');
    overlay.classList.remove('active');
}

// Torne as funções globais
window.toggleSidebar = toggleSidebar;
window.closeSidebar = closeSidebar;