import fs from "fs";

import { Router } from "express";

const routes = new Router();

// root handler
routes.get("/", (req, res) => {
  // load the WSDL file
  let xml = fs.readFileSync("service.wsdl", "utf8");
  res.send(
    'Node Soap Example!<br /><a href="https://github.com/macogala/node-soap-example#readme">Git README</a>'
  );
});

export default routes;
