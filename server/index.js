const express = require("express");
const {v4} = require('uuid');
const app = express();

const store = [];

app.use(express.json());
app.get("/", (req, res) => {
  try {
    const keyword = req.query.keyword || "";
    const filterId = req.query.filterId || "";
    const searchedList = searchLists(store,keyword,filterId);
    return res.json(searchedList);
  } catch (error) {
    console.log(error);
    res.status(500).end();
  }
});
app.post("/", (req, res) => {
  try {
    const reqBody = req.body;
    reqBody.id = reqBody.id == undefined ? v4() : reqBody.id;
    for (let i = 0; i < store.length; i++) {
      if (store[i].id == reqBody.id ) {
        store[i] = reqBody;
        return res.status(200).end();
      }
    }
    store.push(reqBody);
    return res.send(reqBody.id).end();
  } catch (error) {
    console.log(error);
    res.status(500).end();
  }
});
const port = process.argv[2] || 8080;
app.listen(port, () => console.log(`server start listening on port ${port}`));



const searchLists = (datas,keyword,filterId)=>{

  const filteredData = [];
  for (let i = 0; i < datas.length; i++) {
    console.log(datas[i].id, "--", filterId);
    if(datas[i].id == filterId) continue;
    const files = datas[i].files;
    const newData = {
      address: datas[i].address,
      port:datas[i].port,
      username:datas[i].username,
      id:datas[i].id,
      files: [],
    };
  
    for (let j = 0; j < files.length; j++) {
      if (files[j].filename.toLowerCase().includes(keyword.toLowerCase())) {
        newData.files.push(files[j]);
      }
    }
    if (newData.files.length != 0) {
      filteredData.push(newData);
    }
  }
  return filteredData;

}