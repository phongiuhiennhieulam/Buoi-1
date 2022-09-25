function displayElement(){
    var x = document.getElementById('text')
    
    if(x.style.display == 'none'){
        x.style.display = 'block'
        //y.className = 'fa-solid fa-down'

    }
    else{
        x.style.display = 'none'
        //y.className = 'fa-solid fa-up'
    }
}