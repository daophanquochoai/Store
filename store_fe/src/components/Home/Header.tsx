import React, {useContext} from 'react';
import {Dropdown, Space} from 'antd';
import type { MenuProps } from 'antd';
import { DownOutlined } from '@ant-design/icons';
import Search from "antd/es/input/Search";
import {SearchProps} from "antd/lib/input";
import {MdOutlineAccountCircle} from "react-icons/md";
import {FiHeart} from "react-icons/fi";
import {TiShoppingCart} from "react-icons/ti";
import {IoMdSearch} from "react-icons/io";
import {useNavigate} from "react-router-dom";
import {CommonContext} from "../../context/CommonContext.tsx";
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
type Props = {
    state : number
}
const Header = (props : Props) => {

    const navigation = useNavigate();
    const {isLogin} = useContext(CommonContext);
    console.log(isLogin)

    const onSearch: SearchProps['onSearch'] = (value, _e, info) => console.log(info?.source, value);
    return (
       <div className={'h-[100px] bg-red-500'}>
           <div className={"px-[10%] pt-6 pb-4 fixed z-20 bg-white w-full top-0 right-0"}>
               {/* 1 */}
               <div className={`flex justify-between border-b-2 p-2 items-center`}>
                   <div onClick={ () => navigation('/')} className={'cursor-pointer'}>
                       <img src={"https://demo.templatesjungle.com/foodfarm/images/logo.svg"} alt={"icon"}/>
                   </div>
                   <div className={'flex justify-between bg-gray_primary items-center flex-1 mx-[5%] p-2 rounded-2xl'}>
                       <Dropdown menu={{ items }} className={'p-2 text-gray-400'}>
                           <a onClick={(e) => e.preventDefault()}>
                               <Space>
                                   <p>All Categories</p>
                                   <DownOutlined />
                               </Space>
                           </a>
                       </Dropdown>
                       <input className={'text-xl p-1 outline-none text-gray-300 flex-1 mx-20 bg-gray_primary'} placeholder={"Search more than 200 products"}/>
                       <IoMdSearch className={'text-3xl cursor-pointer text-gray-200 text-end'}/>
                   </div>
                   {
                       !isLogin ?
                           <div className={'flex items-center justify-center gap-2'}>
                               <button className={'bg-green_primary px-4 py-2 text-white'} onClick={()=> navigation('/login')}>Sign Up</button>
                               <button className={'bg-green_primary px-4 py-2 text-white'} onClick={()=> navigation('/register')}>Sign In</button>
                           </div>
                           :
                           <>
                               <div className={'flex gap-4 items-center text-3xl'}>
                                   <div className={'relative group cursor-pointer'}>
                                       <MdOutlineAccountCircle/>
                                       <div className={'group-hover:block hidden absolute z-[9] dropdown-menu right-5 text-base bg-green_primary'}>
                                           <div className={'flex flex-col w-[150px]'}>
                                               <button className={'p-2 text-white hover:bg-white hover:text-green_primary transition-all duration-300 cursor-pointer'}>My Account</button>
                                               <button className={'p-2 text-white hover:bg-white hover:text-green_primary transition-all duration-300 cursor-pointer'}>My Order</button>
                                               <button className={'p-2 text-white hover:bg-white hover:text-green_primary transition-all duration-300 cursor-pointer'}>Logout</button>
                                           </div>
                                       </div>
                                   </div>
                                   <FiHeart />
                                   <TiShoppingCart />
                               </div>
                           </>
                   }
               </div>
               {/* 2 */}
               <div className={`flex ${props.state == 1 ? 'h-0 overflow-hidden' : ''} transition-all duration-700 mt-2`}>
                   <div className={'bg-green_primary p-4'}>
                       <p className={'text-xl font-bold text-white'}>Fruits & Vegetables</p>
                   </div>
                   <div className={'p-4 cursor-pointer'}>
                       <Dropdown menu={{ items }}>
                           <a onClick={(e) => e.preventDefault()}>
                               <Space className={'font-bold  text-gray-400'}>
                                   ALL PRODUCTS
                                   <DownOutlined />
                               </Space>
                           </a>
                       </Dropdown>
                   </div>
                   <div className={'p-4 cursor-pointer hover:bg-green_primary'}>
                       <p className={'font-bold  text-gray-400  hover:text-white'}>Fruits & Vegetables</p>
                   </div>
                   <div className={'p-4 cursor-pointer hover:bg-green_primary'}>
                       <p className={'font-bold  text-gray-400 hover:text-white'}>Fruits & Vegetables</p>
                   </div>
               </div>
           </div>
       </div>
    );
};

export default Header;