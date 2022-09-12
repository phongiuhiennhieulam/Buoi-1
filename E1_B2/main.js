function changeBack(para,boo) {
    var x = document.getElementById(para);
    var y = document.getElementById(boo);
    if(x.style.backgroundColor == "white"){
         y.style.color = "white";
         x.style.backgroundColor = "#1c63fb";
    }else{
        y.style.color = "black";
         x.style.backgroundColor = "white";
    }

}
window.smoothScroll = function(target) {
    var scrollContainer = target;
    do {
        scrollContainer = scrollContainer.parentNode;
        if (!scrollContainer) return;
        scrollContainer.scrollTop += 1;
    } while (scrollContainer.scrollTop == 0);
    
    var targetY = 0;
    do { 
        if (target == scrollContainer) break;
        targetY += target.offsetTop;
    } while (target = target.offsetParent);
    
    scroll = function(c, a, b, i) {
        i++; if (i > 30) return;
        c.scrollTop = a + (b - a) / 30 * i;
        setTimeout(function(){ scroll(c, a, b, i); }, 20);
    }
   
    scroll(scrollContainer, scrollContainer.scrollTop, targetY, 0);
}