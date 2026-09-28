# RichInsights — Native Android V2 Roadmap

> **Master V2 document.** This repository is a clean native Android rebuild. V1 is a prototype/reference only; V1 code and behavior are not assumed to be production-ready.

## 1. Product identity

- **Company/studio:** Ricven Studios Limited
- **Product/platform:** RichInsights
- **Tagline:** **Grow. Excel.**
- **Repository:** `richardoha25-web/daily-quiz-android`

RichInsights is an educational platform, not only a quiz app. The initial platform centers on **Home, Learn, Quiz, Bible, and News**, with Profile & Settings as secondary/global navigation.

The native V2 architecture must make future learning tools, content libraries, study features, progress, accounts, and commercial capabilities possible without rebuilding the application shell.

## 2. V2 reset principle

V2 is a **new architecture**, not a port of React/Vite/Capacitor.

V1 may be inspected for:
- product lessons;
- useful UX ideas;
- known failures;
- requirements we do not want to repeat.

V1 must **not** be treated as a source of production-ready code, question data, API architecture, AdMob implementation, or application structure.

Do not mechanically copy V1 systems into V2.

## 3. Primary navigation

### Compact phones
**Home | Learn | Quiz | Bible | News**

### Secondary/global
**Profile & Settings** is accessed from the top app bar/profile action rather than taking a sixth primary slot.

### Adaptive behavior
On larger windows, primary navigation should adapt to a navigation rail or another appropriate adaptive pattern rather than forcing a phone-sized bottom bar. Android currently recommends 3–5 primary destinations for compact navigation and adapting navigation for larger screens. citeturn0search0turn0search1

Top-level destinations should retain their navigation state/back stack where appropriate. Navigation 3 is a strong candidate for V2 because it provides explicit back-stack control and adaptive navigation patterns; the exact library/version will be locked during implementation against the current project setup. citeturn0search2turn0search4

## 4. Core V2 architecture

Target stack:
- Kotlin
- Jetpack Compose
- modern Android architecture
- ViewModel
- Coroutines / Flow / StateFlow
- repository/data-source separation
- type-safe navigation approach
- Room where local structured persistence is required
- DataStore for preferences/settings
- native networking
- Hilt if dependency-injection complexity justifies it
- WorkManager only for genuine background work
- native Google Mobile Ads SDK
- backend/provider architecture selected for V2 requirements rather than inherited automatically from V1

Conceptual client flow:

```
Compose UI
   ↓
UI State / ViewModel
   ↓
Repository
   ↓
Remote + Local Data Sources
```

Provider-specific generation logic belongs outside the Android presentation layer.

## 5. Content and question architecture

The question system is being rebuilt from the ground up.

The platform must separate:

1. **Content sources** — APIs, public/structured data, licensed data, manual authoring, curated packs, trusted sources.
2. **Ingestion/normalization** — convert source material into a consistent internal representation.
3. **Verification and validation** — factual, structural, answer, distractor, language, and quality checks.
4. **Question generation/authoring** — create legitimate question variants from verified material.
5. **Question bank** — store approved questions and their provenance.
6. **Selection engine** — choose appropriate fresh questions for a user/session.
7. **History** — record what the user has already seen.

Question identity must support at least:
- `factId`
- `familyId`
- `variantId`
- `questionId`
- category/topic
- difficulty
- provenance/source
- validation/lifecycle status

A wording change does not automatically make a genuinely new educational question. Family-level repetition must be controlled where appropriate.

### Scale requirement

V2 must be capable of growing to a very large question universe, potentially millions of legitimate variants over the life of the platform. Scale must come from verified content and meaningful variants, not low-quality duplication.

The system must continuously replenish content. A small exhausted cache must not be the normal failure mode.

## 6. Provider independence

No single provider is the architecture.

Providers may be added, removed, replaced, or combined without rewriting the quiz engine. A provider outage, pricing change, quota, or quality problem should be isolated from the learner-facing quiz experience as much as reasonably possible.

The final provider mix is deliberately **not locked yet**.

## 7. Initial learning/content areas

The initial product direction includes:
- General Knowledge
- Science
- Africa & Nigeria
- Current Affairs
- Bible

**News** is a separate top-level product area and should not be treated as merely another Current Affairs API.

Bible is a dedicated platform section, not simply a quiz category.

## 8. Bible direction

Planned future Bible capabilities:
- offline reading using appropriately licensed text;
- book/chapter navigation;
- search;
- online Bible quizzes;
- future study tools;
- user-triggered read-aloud with play/pause/resume/stop controls.

WEB remains the leading translation direction from earlier planning, but licensing/distribution requirements must be verified before implementation or distribution.

Read-aloud must never start automatically when a chapter opens.

## 9. Network and local data behavior

Online quiz/content features require internet access.

The app must provide deliberate states for:
- online;
- connecting;
- offline;
- connection lost;
- loading/requesting;
- empty result;
- temporary failure;
- retry.

Local persistence may store question history, settings, and other intentionally local data. Cached history must not silently become an offline quiz source unless that behavior is explicitly designed.

## 10. Monetization and commercial architecture

V2 will use a fresh commercial architecture rather than copying V1.

Planned capabilities:
- AdMob advertising;
- optional rewarded ads;
- Premium subscription;
- Remove Ads;
- premium content/features;
- future content packs;
- Google Play Billing;
- centralized entitlement state.

Commercial enforcement is **not** an initial prerequisite for the native shell.

The client must not let individual question providers, screens, or question records independently decide Premium access.

## 11. Development and quality rules

Use:

**BUILD → INSTALL → TEST → FIX → DOCUMENT → CHECKPOINT → NEXT STAGE**

Requirements:
- keep V1 untouched while V2 is built;
- keep V2 buildable at every meaningful checkpoint;
- test on real Android hardware;
- add automated tests where they provide meaningful protection;
- do not optimize for feature count at the expense of reliability;
- document only decisions that remain useful to implementation.

## 12. Implementation stages

### Stage 0 — Requirements and architecture
**Status: documented**

Lock product identity, V2 reset principle, navigation, architecture boundaries, content/question requirements, and major quality requirements.

### Stage 1 — Native application foundation
- Kotlin/Compose project setup
- package/application identity
- Gradle/build configuration
- theme/design-system foundation
- navigation shell
- build/install pipeline

### Stage 2 — Platform UI foundation
- RichInsights visual system
- reusable components
- adaptive layouts
- loading/error/empty states
- accessibility foundations
- Home/Learn/Quiz/Bible/News shell

### Stage 3 — Content/domain contracts
- category/topic models
- question/fact/family/variant/ID models
- provenance and validation metadata
- quiz-session/result models
- stable API contracts

### Stage 4 — Quiz engine
- session state
- question presentation
- answer handling
- timer
- scoring
- progression
- completion/results
- failure/retry states

### Stage 5 — Backend/content integration
- connect to the selected V2 backend/content services
- network handling
- content validation boundaries
- provider-independent contracts

### Stage 6 — History and freshness
- local history persistence
- exact-question and family-level repetition rules
- selection/freshness integration
- replenishment behavior

### Stage 7 — Initial content rollout
Bring categories online incrementally:
- General Knowledge
- Science
- Africa & Nigeria
- Current Affairs
- Bible quiz capability where ready

### Stage 8 — Bible platform experience
- offline reader
- licensed content
- search/navigation
- read-aloud controls
- Bible-specific study foundations

### Stage 9 — News and broader platform features
- News experience
- progress/account foundations
- future learning resources
- additional educational modules

### Stage 10 — Commercial and release hardening
- native AdMob
- Google Play Billing when required
- entitlement enforcement
- performance/accessibility/security testing
- release preparation

Stages can be subdivided as implementation progresses. A stage is complete only when its scope is tested and documented.

## 13. Definition of success

V2 succeeds when RichInsights has a maintainable native Android foundation with:
- clear platform navigation;
- strong quiz/session behavior;
- scalable and provider-independent content architecture;
- validated, traceable questions;
- robust repetition prevention and freshness;
- continuous content replenishment;
- deliberate Bible support;
- reliable network behavior;
- adaptive native UI;
- clean separation of client, content, infrastructure, and commercial concerns;
- room for future educational products.

**V2 is an educational platform foundation — not V1 rebuilt with a new UI.**
