
export default function UserGreeting({ setIsLoggedIn }) {
    return (
        <div>
            <h1>Welcome back</h1>
            <button onClick={() => setIsLoggedIn(false)}>Logout</button>
        </div>
    )
}
