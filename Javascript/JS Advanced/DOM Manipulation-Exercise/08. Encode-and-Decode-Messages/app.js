function encodeAndDecodeMessages() {
    const eBtn = document.querySelectorAll('button')[0];
    const dBtn = document.querySelectorAll('button')[1];
    const sArea = eBtn.parentNode.querySelector('textarea');
    const rArea = dBtn.parentNode.querySelector('textarea');
 
    function encode() {
        rArea.value = sArea.value
            .split('')
            .map(char => char.charCodeAt() + 1)
            .map(ascii => String.fromCharCode(ascii))
            .join('');
        sArea.value = '';
    }
    function decode() {
        rArea.value = rArea.value
            .split('')
            .map(char => char.charCodeAt() - 1)
            .map(ascii => String.fromCharCode(ascii))
            .join('');
    }
    eBtn.addEventListener('click', encode);
    dBtn.addEventListener('click', decode);
}