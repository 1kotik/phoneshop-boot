document.getElementById('searchForm').addEventListener('submit', removeEmptyInputs);

function removeEmptyInputs() {
    this.querySelectorAll('input').forEach(input => {
        const inputValue = input.value.trim();
        if (inputValue === '') {
            input.disabled = true;
        }
    });
}

