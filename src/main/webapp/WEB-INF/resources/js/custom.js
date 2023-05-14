  const filterPosition = document.querySelector('.filter-position');
  selectPositionBtn  = filterPosition.querySelector('.filter-position .select-btn');

  selectPositionBtn.addEventListener("click", () => {
    filterPosition.classList.toggle("active");
  })

  const filterJob = document.querySelector('.filter-job');
  selectJobBtn  = filterJob.querySelector('.filter-job .select-btn');

  selectJobBtn.addEventListener("click", () => {
    filterJob.classList.toggle("active");
  })

  const filterformality = document.querySelector('.filter-formality-job');
  selectFormality = filterformality.querySelector('.filter-formality-job .select-btn');

  selectFormality.addEventListener("click", () => {
    filterformality.classList.toggle("active");
  })
  
  var job_list = document.querySelectorAll("#opt-job li");

  for (let i = 0 ; i<job_list.length;i++){
    job_list[i].onclick = function() {
      document.getElementById("txt-job").textContent = job_list[i].textContent;
      filterJob.classList.toggle("active");
    }
  }

  var position_list = document.querySelectorAll("#opt-position li");

  for (let i = 0; i< position_list.length ; i++) {
    position_list[i].onclick = function() {
      document.getElementById("txt-position").textContent = position_list[i].textContent;
      filterPosition.classList.toggle("active");
    }
  }

  var formality_list = document.querySelectorAll("#opt-formality li");

  for (let i = 0; formality_list.length ; i++) {
    formality_list[i].onclick = function() {
      document.getElementById("txt-formality").textContent = formality_list[i].textContent;
      filterformality.classList.toggle("active");
    }
  }

  function search_active() {
    let job_select = document.getElementById("txt-job").textContent;
    let position_select = document.getElementById("txt-position").textContent;
    let formality_select = document.getElementById("txt-formality").textContent;

    if (job_select !== 'Chọn ngành nghề' || position_select !== 'Chọn khu vực' || formality_select !== 'Chọn hình thức') {
		if (job_select === 'Chọn ngành nghề') job_select = '';
		if (position_select === 'Chọn khu vực') position_select ='';
		if (formality_select === 'Chọn hình thức') formality_select ='';
      window.location.href = '/wJob/recruiter/search?job='+job_select+'&position='+position_select+'&formality='+formality_select;
    }
  }