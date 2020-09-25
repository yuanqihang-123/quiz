import React from 'react';
import './App.css';
import {Route, BrowserRouter, Link, Switch} from "react-router-dom";
import Products from "./products/Products";
import Order from './order/Order'
import AddProduct from './addProduct/AddProduct'
function App() {
  return (
    <BrowserRouter>
      <header className='app_header'>
        <Link className="div_nav_link" to='/'>商城</Link>
        <Link className="div_nav_link" to='/order'>订单</Link>
        <Link className="div_nav_link" to='/addProduct'>添加商品</Link>
      </header>
      <Switch>
        <Route exact path='/' component={Products}></Route>
        <Route exact path='/order' component={Order}></Route>
        <Route exact path='/addProduct' component={AddProduct}></Route>
      </Switch>
    </BrowserRouter>
  );
}

export default App;
