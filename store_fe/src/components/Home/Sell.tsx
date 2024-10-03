import React from 'react';
import Item from "./Item.tsx";
import NavItem from "./NavItem.tsx";
import {IoFastFood} from "react-icons/io5";

const Sell = () => {
    return (
        <div className={'mx-[10%] mt-16 grid grid-cols-[1fr_3fr] gap-4'}>
          <div className={'flex flex-col gap-2 max-h-[400px] overflow-y-scroll'}>
              <NavItem />
              <NavItem />
              <NavItem />
              <NavItem />
              <NavItem />
          </div>
          <div>
              <div className={'flex justify-between'}>
                  <p className={'text-3xl font-bold'}>Best selling products</p>
                  <button className={'bg-green_primary p-2 rounded-[7px] text-white hover:bg-yellow-200 transition-all duration-300'}>View All</button>
              </div>
              <div className={'grid grid-cols-4 mt-4 gap-4'}>
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
          </div>
        </div>
    );
};

export default Sell;