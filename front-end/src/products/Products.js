import React, {Component, Fragment} from 'react';
import './Products.css'
import Product from "../product/Product";

class Products extends Component {

    state = {
        products: []
    };



    async componentDidMount() {
        const response = await fetch('http://localhost:8080/products');
        const json = await response.json();
        console.log(json)
        this.setState({
            products: json,
        })
    };
    // handleClick={this.handleClick}
    render() {
        return (
            <div className="products_div">
                {
                    this.state.products.map((item, index) => {
                        return <Product
                            key={index}
                            product={item}

                        ></Product>
                    })
                }
            </div>
        );
    }
}

export default Products;
