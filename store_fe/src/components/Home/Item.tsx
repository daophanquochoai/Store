import React from 'react';
import {Badge, Rate} from "antd";
import {FaCartPlus} from "react-icons/fa";

const Item = () => {
    return (
        <div className={'p-4 h-[400px] hover:border-gray_primary hover:border-4 cursor-pointer transition-all duration-500 group'}>
            <Badge.Ribbon text="Hippies" color="green">
                <img src={'https://demo.templatesjungle.com/foodfarm/images/product-thumbnail-1.png'} alt={'icon'} className={'w-full h-auto'}/>
            </Badge.Ribbon>
            <div>
                <p className={'text-center'}>Whole Wheat Sandwich Bread</p>
                <div className={'flex items-center gap-2'}>
                    <Rate disabled defaultValue={2} />
                    <span className={'text-gray-300'}>(44)</span>
                </div>
                <div className={'flex justify-center gap-4 items-center mt-4'}>
                    <div className={'group-hover:hidden transition-all duration-300'}>
                        <del className={'text-gray-300'}>$22.40</del>
                        <span>$18.00</span>
                    </div>
                    <div className={'hidden group-hover:block transition-all duration-300'}>
                        <div className={'flex items-center justify-center'}>
                            <button className={'border-2 px-2'}>-</button>
                            <span className={'px-2'}>1</span>
                            <button className={'border-2 px-2'}>+</button>
                        </div>
                        <div className={'flex items-center gap-4 text-white bg-green_primary p-2 rounded-[7px] mt-2'}>
                            <FaCartPlus />
                            <button>Add to Cart</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default Item;