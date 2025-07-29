import officeImage from './assets/OfficeSpace.jpg';

function App() {
  const title = "Office Space";

  const RenderImage = () => {
    return (
      <img src={officeImage} alt="Office Space"
        style={{
          width: '25%',
          height: '25%',
          display: 'block',
          minWidth: 200,
          aspectRatio: 1
        }}
      />
    )
  }

  const office = {
    Name: "DBS",
    Rent: 50000,
    Address: "Chennai"
  }

  return (
    <div>
      <h1>{title}, at Affordable Range</h1>
      <RenderImage />
      <h1>Name: {office.Name}</h1>
      <h1 style={{color: office.Rent <= 60000 ? "red" : "green"}}>
        Rent: Rs. {office.Rent}
      </h1>
      <h1>Address: {office.Address}</h1>
    </div>
  )
}

export default App
