fetch("http://localhost:8082/os/get-people-json")
  .then(function (response) {
    console.log("success!", response);
  })
  .catch(function (err) {
    console.warn("Something went wrong.", err);
  });
