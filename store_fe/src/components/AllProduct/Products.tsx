import React, {useState} from 'react';
import SideLeft from "./SideLeft.tsx";
import Item from "../Home/Item.tsx";
import {Dropdown, MenuProps, Pagination, Space} from "antd";
import {DownOutlined} from "@ant-design/icons";

const Products:React.FC = () => {
    const items: MenuProps['items'] = [
        {
            key: '1',
            label: 'My Account',
            disabled: true,
        },
        {
            key: '2',
            label: 'Profile'
        },
        {
            key: '3',
            label: 'Billing'
        },
        {
            key: '4',
            label: 'Settings'
        },
    ];
    const [selected,  setSelected] = useState<number>(1);
    return (
        <div className={'grid grid-cols-[1fr_4fr]'}>
            <SideLeft />
            <div>
                <div className={'flex justify-between items-center px-4 mb-4'}>
                    <div className={'text-xl'}>Showing 1–9 of 55 results</div>
                    <div className={'border-2 cursor-pointer'}>
                        <Dropdown menu={{ items, onClick : (e) => console.log(e)}} className={'p-2 text-gray-400'} >
                            <Space>
                                <p>Sort By</p>
                                <DownOutlined />
                            </Space>
                        </Dropdown>
                    </div>
                </div>
                <div className={'grid grid-cols-6 gap-4'}>
                    <Item />
                    <Item />
                    <Item />
                    <Item />
                    <Item />
                    <Item />
                    <Item />
                    <Item />
                    <Item />
                    <Item />
                    <Item />
                    <Item />
                    <Item />
                    <Item />
                    <Item />
                    <Item />
                    <Item />
                    <Item />
                </div>
                <div className={'flex items-center justify-center py-8'}>
                    <Pagination defaultCurrent={1} total={50} />
                </div>
            </div>
        </div>
    );
};

export default Products;