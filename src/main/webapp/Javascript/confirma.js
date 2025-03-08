class ConfirmationPopup {
  constructor(buttonId, formId) {
    this.buttonId = buttonId;
    this.formId = formId;
    this.button = document.getElementById(buttonId);
    this.form = document.getElementById(formId);

    this.attachEvent();
  }

  attachEvent() {
    this.button.addEventListener('click', this.showConfirmation.bind(this));
  }

  showConfirmation(event) {
    event.preventDefault();
    const confirmation = confirm('Deseja alterar o status?');
    if (confirmation) {
      this.form.submit();
    }
  }
}

const popup = new ConfirmationPopup('botaoStatus', 'formularioStatus');