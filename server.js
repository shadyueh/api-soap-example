import app from "./app.js";
import soap from "soap";

const port = process.env.PORT;

// Launch the server and listen
app.listen(port, function () {
  const wsdl_path = process.env.WSDL_PATH;
  let options = {
    path: wsdl_path,
    services: app.serviceObject,
    xml: app.xml,
  };

  soap.listen(app, options);

  console.log("Listening on port " + port);
  console.log(
    "Check http://localhost:" +
      port +
      wsdl_path +
      "?wsdl to see if the service is working"
  );
});
