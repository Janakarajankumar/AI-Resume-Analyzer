import { useState } from "react";
import axios from "axios";

function App() {

  const [file, setFile] = useState(null);
  const [result, setResult] = useState("");

  const uploadResume = async () => {

    if (!file) {
      alert("Please select a PDF file");
      return;
    }

    const formData = new FormData();
    formData.append("file", file);

    try {

   const response = await axios.post(
  "http://localhost:8081/api/analyze",
  formData
);

      setResult(response.data);

    } catch (error) {

  console.log(error);

  if (error.response) {
    console.log(error.response.data);
    alert(error.response.data);
  } else {
    alert("Backend connection failed");
  }
}
  };

  return (
    <div style={{
      padding: "40px",
      fontFamily: "Arial",
      maxWidth: "800px",
      margin: "auto"
    }}>

      <h1>AI Resume Analyzer</h1>

      <input
        type="file"
        accept=".pdf"
        onChange={(e) => setFile(e.target.files[0])}
      />

      <br /><br />

      <button
        onClick={uploadResume}
        style={{
          padding: "10px 20px",
          cursor: "pointer"
        }}
      >
        Analyze Resume
      </button>

      <br /><br />

      <pre
        style={{
          background: "#f4f4f4",
          padding: "20px",
          borderRadius: "10px",
          overflowX: "auto",
          color: "black"
        }}
      >
        {typeof result === "string"
          ? result
          : JSON.stringify(result, null, 2)}
      </pre>

    </div>
  );
}

export default App;