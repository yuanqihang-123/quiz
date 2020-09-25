import React, { Component } from 'react';
import './Product.css'

class Product extends Component {

    render() {
        return (
            <div className="product_div">
                <img src={this.props.product.url} alt="商品" className="product_img"/>
                <div>
                    {this.props.product.name}
                </div>
                <div>
                    单价:{this.props.product.price}元/{this.props.product.unit}
                </div>
                <div className="div_plus">
                    <input
                        type='button'
                        value="+"
                        onClick={()=> this.props.handleClick(this.props.product)}
                    />
                </div>
            </div>
        );
    }
}

export default Product;
