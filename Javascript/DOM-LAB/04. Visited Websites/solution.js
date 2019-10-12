function solve() {
  function clickEvent() {
      let textElement = this.parentNode.children[1];
      let text = textElement.innerText.toString();
      let number = text.match(/\d+/)[0];
      text = text.replace(number, (+number + 1).toString());
      textElement.innerHTML = text;
  }
  //add event to links
  let linkElements = document.querySelectorAll('#exercise a');

  for (let linkElement of linkElements){
      linkElement.addEventListener('click', clickEvent);
  }
}
