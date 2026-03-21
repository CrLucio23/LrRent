export default function ContattiPage() {
  return (
    <section className="section page-shell">
      <div className="container narrow-layout">
        <div className="section-heading">
          <div>
            <span className="eyebrow">Contatti</span>
            <h1>Parla con LrRent</h1>
          </div>
          <p>Pagina vetrina pronta da personalizzare con i tuoi dati reali.</p>
        </div>

        <div className="grid contact-grid">
          <div className="card">
            <h2>Email</h2>
            <p>info@lrrent.it</p>
          </div>
          <div className="card">
            <h2>Telefono</h2>
            <p>+39 333 1234567</p>
          </div>
          <div className="card">
            <h2>Sede</h2>
            <p>Via Roma 123, Napoli</p>
          </div>
          <div className="card">
            <h2>Orari</h2>
            <p>Lun - Sab · 09:00 - 19:00</p>
          </div>
        </div>
      </div>
    </section>
  );
}
