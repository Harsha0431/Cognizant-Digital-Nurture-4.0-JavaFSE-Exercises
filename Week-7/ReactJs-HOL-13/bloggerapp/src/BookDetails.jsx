
export default function BookDetails(props) {
    return (
        <div>
            {
                props.books.map((book) => <div key={book.id}>
                    <h2>{book.bname}</h2>
                    <b>{book.price}</b>
                </div>)
            }
        </div>
    )
}
