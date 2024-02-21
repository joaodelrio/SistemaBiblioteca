import React from "react";
import { Link, Outlet } from "react-router-dom";

const Home = () => {
  return (
    <div>
      <h1>Página Inicial</h1>
      <Link to="/alunos">
        <button>Alunos</button>
      </Link>
      <Link to="/livros">
        <button>Livros</button>
      </Link>
      <Outlet />
    </div>
  );
};

export default Home;
