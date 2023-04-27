import { useEffect, useState } from "react";

const List = () => {
  const [people, setPeople] = useState([]);
  // const [indirizzo, setIndirizzo] = useState();
  // const [nome, setNome] = useState();
  // const [cognome, setCognome] = useState();
  const [utente, setUtente] = useState({
    nome: "",
    cognome: "",
    indirizzo: "",
  });

  const handleChange = (property, value) => {
    setUtente({ [property]: value });
  };

  const handleSubmit = () => {
    postPeople();
  };

  const fetchPeople = async () => {
    try {
      const response = await fetch("http://localhost:8081/app/data3");
      if (response.ok) {
        const data = await response.json();
        setPeople(data);
      } else {
        alert("errore nel fetch");
      }
    } catch (error) {
      console.log(error);
    }
  };

  const postPeople = async () => {
    try {
      const response = await fetch("http://localhost:8081/app/data4", {
        method: "POST",
        headers: {
          Accept: "application/json",
          "Content-Type": "application/json",
        },
        body: JSON.stringify(utente),
      });

      if (response.ok) {
        const data = await response.json();
      } else {
      }
    } catch (error) {
      console.log(error);
    }
  };

  useEffect(() => {
    fetchPeople();
  }, []);

  useEffect(() => {
    postPeople();
  }, []);

  return (
    <div>
      <ul>
        {people &&
          people.map((p) => (
            <li key={p.id}>
              {p.nome} - {p.cognome} - {p.indirizzo}
            </li>
          ))}
      </ul>
      <form>
        <input
          type="text"
          placeholder="nome"
          onChange={(e) => handleChange("nome", e.target.value)}
        ></input>
        <input
          type="text"
          placeholder="cognome"
          onChange={(e) => handleChange("cognome", e.target.value)}
        ></input>
        <input
          type="text"
          placeholder="indirizzo"
          onChange={(e) => handleChange("indirizzo", e.target.value)}
        ></input>
        <button onSubmit={(e) => handleSubmit(e)}>Aggiungi</button>
      </form>
    </div>
  );
};

export default List;
