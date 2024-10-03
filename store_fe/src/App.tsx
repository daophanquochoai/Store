import Home from "./pages/Home.tsx";
import {Route, Routes, useRoutes} from "react-router-dom";
import Header from "./components/Home/Header.tsx";
import {useEffect, useState} from "react";
import Footer from "./components/Home/Footer.tsx";
import AllProduct from "./pages/AllProduct.tsx";
import Container from "./pages/Container.tsx";
import {ToastContainer} from "react-toastify";
import 'react-toastify/dist/ReactToastify.css';
import Login from "./pages/Login.tsx";
import OAuth2Redict from "./pages/OAuth2Redict.tsx";
import NotFoundPage from "./pages/NotFoundPage.tsx";

const routes = [
    {
        path : '/',
        element : <Container />,
        children : [
            {
                index : true,
                element : <Home />
            },
            {
                path: '/all-category',
                element: <AllProduct />
            }
        ]
    },
    {
        path: '/login',
        element: <Login />
    },
    {
        path: '/oauth2/redirect',
        element: <OAuth2Redict />
    },{
        path: '*',
        element: <NotFoundPage />
    }
]

function App() {
    const element = useRoutes(routes);
  return (
    <>
        <ToastContainer autoClose={4000}/>
        {element}
    </>
  )
}

export default App
