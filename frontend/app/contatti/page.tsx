export default function ContattiPage() {
  return (
    <section className="section page-shell">
      <div className="container narrow-layout">
        <div className="section-heading">
          <div>
            <span className="eyebrow">Contatti</span>
            <h1>Parla con LrRent</h1>
          </div>
        </div>
        <div className="grid contact-grid">
          <div className="card">
            <h2>Email</h2>
            <p>info@lrrent.it</p>
          </div>
          <div className="card">
            <h2>Telefono</h2>
            <p>Fabio: +39 328 2393093</p>
            <p>Liberato: +39 333 5367762</p>
          </div>
          <div className="card">
            <h2>Sede</h2>
            <p>Via Napoli 45, Nocera Inferiore (SA)</p>
          </div>
          <div className="card">
            <h2>Orari</h2>
            <p>Lun - Ven · 09:00 - 20:00</p> <p>Sab · 09:00 - 13:00</p> 
          </div>
        </div>
      </div>
    </section>
  );
}
