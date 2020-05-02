import React from 'react';
import Header from '../Pagelvl_Components/Header';
import Content from '../Pagelvl_Components/Content';
import Footer from '../Pagelvl_Components/Footer';

export default class HomePage extends React.Component{
    render(){
        return(
            <div>
                <Header/>
                <Content/>
                <Footer/>
            </div>
        )
    }
}