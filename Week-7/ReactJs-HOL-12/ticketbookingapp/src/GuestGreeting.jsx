
export default function GuestGreeting({ setIsLoggedIn }) {
    return (
        <div>
            <h1>Please Sign up.</h1>
            <button onClick={() => setIsLoggedIn(true)}>Login</button>
        </div>
    )
}
