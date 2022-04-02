 function go_back(id){   
    
        window.addEventListener("scroll", handle);
        function handle() {
            // 兼容性
            var bTop = document.body.scrollTop || document.documentElement.scrollTop;
            if (bTop >= 100) {
                id.style.display = "block";
            } else {
                id.style.display = "none";
            }
            id.onclick = function () {
                window.scrollTo({
                    top: 0,
                    behavior: "smooth"
                })
            }
        }
    }

