import React, {createContext, ReactNode, useState} from 'react';

type contextValue =  {
    isLogin :  boolean,
    setIsLogin : (state : boolean) => void,
}

export const CommonContext = createContext<contextValue | undefined>(undefined);

const CommonProvider : React.FC = ({children} : {children:ReactNode}) => {
    const [isLogin, setIsLogin] = useState<boolean>(false);
    const value: contextValue = {
        isLogin : isLogin,
        setIsLogin : setIsLogin
    }
    return (
        <CommonContext.Provider value={value}>
            {children}
        </CommonContext.Provider>
    );
};

export default CommonProvider;