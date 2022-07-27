import "dotenv/config";

import express from "express";
import http from "http";

import routes from "./routes.js";

class App {
  constructor() {
    // create express app
    this.app = express();
    this.server = http.Server(this.app);

    // the service
    this.serviceObject = {
      MessageSplitterService: {
        MessageSplitterServiceSoapPort: {
          MessageSplitter: this.splitter_function,
        },
        MessageSplitterServiceSoap12Port: {
          MessageSplitter: this.splitter_function,
        },
      },
    };

    this.middlewares();

    // setup routes
    this.routes();
  }

  middlewares() {}

  routes() {
    this.app.use(routes);
  }

  // the splitter function, used by the service
  splitter_function(args) {
    let splitter = args.splitter;
    let splitted_msg = args.message.split(splitter);
    let result = [];

    for (let i = 0; i < splitted_msg.length; i++) {
      result.push(splitted_msg[i]);
    }

    return {
      result: result,
    };
  }
}

export default new App().server;