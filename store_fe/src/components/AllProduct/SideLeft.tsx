import React, {useState} from 'react';
import {RadioChangeEvent, Slider} from "antd";
import { Radio } from 'antd';
import {FaSearch, FaStar} from "react-icons/fa";
const SideLeft : React.FC = () => {
    const [value, setValue] = useState<number>(2);
    const [price, setPrice] = React.useState<number[]>([20, 80]);
    const onChange = (e: RadioChangeEvent) => {
        console.log('radio checked', e.target.value);
        setValue(e.target.value);
    };
    return (
        <div className={'p-6 flex flex-col gap-6'}>
            <div>
                <div className={'flex justify-center items-center gap-4 bg-gray-200  rounded-[7px] px-4'}>
                    <input className={'flex-1 text-base px-2 py-2 bg-gray-200 outline-0'} placeholder={"Search here"}/>  <FaSearch className={'text-gray-400'}/>
                </div>
            </div>
            <div className={'flex flex-col gap-4'}>
                <div>
                    <h3 className={'text-2xl font-bold mb-2'}>Categories</h3>
                    <div>
                        <p className={'text-green_primary cursor-pointer text-xl'}>All</p>
                        <p className={'text-gray-300 hover:text-green_primary cursor-pointer text-xl'}>Fresh</p>
                        <p className={'text-gray-300 hover:text-green_primary cursor-pointer text-xl'}>Organic</p>
                    </div>
                </div>
                <div className={'flex flex-col'}>
                    <h3 className={'text-2xl font-bold'}>Rate</h3>
                    <Radio.Group onChange={onChange} value={value} className={'flex flex-col gap-2'}>
                        <Radio value={5}>
                            <div className={'flex items-center justify-center text-base gap-2'}>
                                <p>Từ 5</p> <FaStar className={'text-yellow-300'}/>
                            </div>
                        </Radio>
                        <Radio value={4}>
                            <div className={'flex items-center justify-center text-base gap-2'}>
                                <p>Từ 4</p> <FaStar className={'text-yellow-300'}/>
                            </div>
                        </Radio>
                        <Radio value={3}>
                            <div className={'flex items-center justify-center text-base gap-2'}>
                                <p>Từ 3</p> <FaStar className={'text-yellow-300'}/>
                            </div>
                        </Radio>
                        <Radio value={2}>
                            <div className={'flex items-center justify-center text-base gap-2'}>
                                <p>Từ 2</p> <FaStar className={'text-yellow-300'}/>
                            </div>
                        </Radio>
                    </Radio.Group>
                </div>
                <div>
                    <h3 className={'text-2xl font-bold'}>Price</h3>
                    <div>
                        <Slider
                            range={{ minCount: 1, maxCount: 5 }}
                            value={price}
                            onChange={setPrice}
                        />
                    </div>
                </div>
            </div>
        </div>
    );
};

export default SideLeft;