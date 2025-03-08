document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('rd1').addEventListener('change', function() {
        if(this.checked) {
            document.querySelector('.Form2').classList.add('hidden');
        }
    });

    document.getElementById('rd2').addEventListener('change', function() {
        if(this.checked) {
            document.querySelector('.Form2').classList.remove('hidden');
        }
    });
});


