const btn01 = document.getElementById('btn01');
btn01.onclick = () => {
    fetch("../test")
	    .then(resp => resp.json())
	    .then(members => {
            console.log(members);
        });
};
