import { useState } from 'react';
import GuestGreeting from './GuestGreeting';
import UserGreeting from './UserGreeting';

export default function Greeting() {
    const [isLoggedIn, setIsLoggedIn] = useState(false);

    return (
        <div>
            {isLoggedIn ? <UserGreeting setIsLoggedIn={setIsLoggedIn} /> : <GuestGreeting setIsLoggedIn={setIsLoggedIn} />}
        </div>
    )
}
