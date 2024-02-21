import React from "react";
import { Link, Outlet } from "react-router-dom";
import '../styles/Home.css';

const Home = () => {
  return (
    <div className="container-home">
      <div className="container-fundo">
        <h1 className="titulo">Página Inicial</h1>
        <div className="botoes">
          <Link to="/alunos">
            <button>Alunos</button>
          </Link>
          <Link to="/livros">
            <button>Livros</button>
          </Link>
          <Outlet />
        </div>
      </div>
    </div>
  );
};

export default Home;
