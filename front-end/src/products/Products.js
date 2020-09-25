import React, {Component, Fragment} from 'react';
import './Products.css'
import Product from "../product/Product";

class Products extends Component {

    state = {
        products: []
    };

    handleClick = (product) => {
        //发送请求到后端，添加商品到订单
    }

    async componentDidMount() {
        const response = await fetch('http://localhost:8080/products');
        const json = await response.json();
        this.setState({
            products:json,
        })
    }

    render() {
        return (
            <div className="products_div">
                {
                    this.state.products.map((item,index)=>{
                        return <Product
                            key={index}
                            product={item}
                            handleClick={this.handleClick}
                        ></Product>
                    })
                }
            </div>
        );
    }
}

export default Products;
