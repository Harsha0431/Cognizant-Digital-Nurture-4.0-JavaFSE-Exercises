import logo from './logo.svg';
import './App.css';
import { CohortsData} from './Cohort'
import CohortDetails from './CohortDetails';
import './CohortDetails.module.css';

function App() {
  return (
  <div>
      <h1>Cohorts Details</h1>
      <div style={{display: 'flex', gap: '10px', flexWrap: 'wrap'}} >
        {CohortsData.map(cohort => <CohortDetails cohort={cohort}/>)}
      </div>
  </div>
  );
}

export default App;
