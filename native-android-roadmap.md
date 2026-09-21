# Daily Quiz Android — Native Android Roadmap

> Master planning and continuity document for the native Android implementation of **Daily Quiz & Challenge**.

**Repository:** `richardoha25-web/daily-quiz-android`  
**Application direction:** Native Android  
**Primary stack:** Kotlin + Jetpack Compose  
**Development model:** Incremental, test-driven stages  
**Current status:** Planning complete; implementation not started

---

## 1. Purpose of This Repository

This repository is the planned native Android implementation of Daily Quiz & Challenge.

It is intentionally separate from the existing:

- `daily-quiz-challenge` — React + Vite + Capacitor application

The existing React application remains an active project. It is not being deleted, abandoned, or treated as wasted work.

The native repository exists so that we can build a stronger Android client while preserving the product knowledge, backend work, testing experience, and decisions already learned from V1.

### Product relationship

**V1**
- React
- Vite
- Capacitor
- Existing working Android application

**Native Android**
- Kotlin
- Jetpack Compose
- Native Android architecture
- Separate repository

A later native release may potentially become an update/replacement path for the existing Android application, but that requires deliberate testing of package identity, signing, versioning, local data, and update behavior. It must not be assumed automatically.

---

# 2. Core Product Direction

The native Android version is intended to support a polished, serious quiz product with:

- High-quality Android UI
- Strong graphics and interaction
- Good performance
- Reliable internet-dependent quiz operation
- Clear network/connectivity states
- Expandable category architecture
- Bible reading/library capabilities
- Native advertising
- Future premium/commercial features
- Maintainable long-term architecture

The first priority is **a strong Android application**, not building every future system at once.

---

# 3. Development Philosophy

We will build this project **stage by stage**, just as the existing React application was built.

We will NOT attempt to build all of these simultaneously:

- Quiz engine
- Every category
- Backend replacement
- Firebase
- Authentication
- Premium
- Subscriptions
- Google Play Billing
- Final AdMob setup
- Full analytics
- Complete Bible system
- iOS

Instead:

**BUILD → INSTALL → TEST → FIX → DOCUMENT → CHECKPOINT → NEXT STAGE**

A feature is not considered complete simply because the code compiles.

Each meaningful stage should be:

1. Implemented
2. Built successfully
3. Installed on a real Android device when practical
4. Tested
5. Fixed where necessary
6. Documented
7. Committed to GitHub
8. Given a clear next step

---

# 4. Native Technology Direction

## Primary language

**Kotlin**

## UI

**Jetpack Compose**

Google's current Android documentation identifies Jetpack Compose as the preferred Android UI toolkit and describes it as the direct route for high-quality native Android experiences. Compose also supports responsive/adaptive UI across different form factors.

## Architecture components

The initial architecture will use modern Android/Jetpack components where they provide clear value:

- Jetpack Compose
- ViewModel
- Kotlin Coroutines
- Flow / StateFlow
- Lifecycle-aware state collection
- Repository/data-source separation
- Navigation for Compose
- Room when structured local persistence is needed
- DataStore for lightweight preferences/settings
- Native Android networking
- Hilt/dependency injection when project complexity justifies it
- WorkManager only when genuine background work is required
- Native Google Mobile Ads SDK
- Existing Cloudflare Worker initially

We will avoid adding libraries merely because they are popular. Every major dependency should have a clear purpose.

---

# 5. Current Android Architecture Direction

The initial target architecture is:

```
                    Compose UI
                       ↓
              Screen / UI State
                       ↓
                  ViewModel
                       ↓
                  Repository
                 ↙          ↘
       Remote Data Source   Local Data Source
                 ↓               ↓
        Cloudflare Worker   Room / DataStore
                 ↓
             APIs / Data
```

The UI should not directly perform network or database operations.

The ViewModel exposes state/events to the UI.

The repository provides a stable boundary between the rest of the application and its data sources.

A domain/use-case layer may be introduced later if the application becomes complex enough to justify it. We will not create unnecessary abstraction layers at the beginning.

---

# 6. Compose Architecture

The initial native application should use a Compose-first structure.

Google's current guidance describes a Compose-only application around a single Activity and screen-level composables, with modern Compose navigation.

The project should therefore avoid building a large Fragment/XML architecture unless a specific Android integration requires it.

### UI principles

- Screen-level composables
- Reusable UI components
- State hoisting where appropriate
- ViewModels for screen/business state
- Lifecycle-aware state collection
- Clear navigation events
- Minimal direct navigation-controller coupling inside reusable components
- Accessibility from the beginning
- Responsive/adaptive layouts

Navigation technology will be selected and pinned at implementation time based on the current stable Android/Jetpack releases. Navigation 3 is part of the current Android ecosystem and is Compose-first, but we will not adopt experimental/rapidly changing APIs merely because they are newer.

---

# 7. Adaptive and Responsive UI

The native application should not be designed only around one fixed phone size.

Current Android guidance emphasizes adaptive layouts for:

- Phones
- Large phones
- Tablets
- Foldables
- Landscape
- Split-screen
- Resizable windows
- Other Android form factors

Compose is well suited to this because layouts can react to available window space.

The design system should therefore use:

- Window size classes
- Responsive layouts
- Maximum content widths where appropriate
- Scrollable content
- Adaptive navigation
- State preservation during configuration/window changes

For compact phone layouts, a bottom navigation pattern may be appropriate where the product has a small number of top-level destinations.

For larger layouts, navigation rail or other adaptive navigation may be appropriate.

The final navigation structure will be determined during UI/UX planning.

---

# 8. Android 15/16 and Modern Platform Considerations

The native application should be developed against current Android requirements rather than copying assumptions from older Android projects.

Important considerations include:

- Current target SDK requirements
- Android 15 edge-to-edge behavior
- Android 16 large-screen/resizability behavior
- Window size changes
- Predictive back
- Accessibility
- Modern permission behavior
- Battery/background restrictions
- Android security requirements

Current Android documentation states that edge-to-edge is enforced by default for apps targeting Android 15/API 35+, so the UI architecture must correctly handle system insets.

Current Android 16 guidance also emphasizes adaptive layouts, state preservation, and avoiding fixed assumptions about orientation/aspect ratio/resizability.

These requirements will be incorporated into the implementation stage rather than retrofitted at the end.

---

# 9. Network and Connectivity Strategy

The quiz product is intentionally **internet-required**.

A strong internet connection is an important part of the user experience.

The native app should clearly communicate:

- Internet required
- Connecting
- Loading
- Connection lost
- Request failed
- Retry available
- Successful connection

Suggested connectivity states:

```
ONLINE
CONNECTING
OFFLINE
CONNECTION_LOST
REQUESTING
ERROR
```

The exact state model will be refined during implementation.

### Important rule

Old cached quiz questions must **not** silently become the offline quiz source.

Local question history may be retained for anti-repetition and related logic, but it is not a substitute for fetching fresh quiz questions online.

---

# 10. Connectivity UX

The app should communicate connectivity requirements early and consistently.

Potential locations:

- Startup/loading screen
- Home/category screen
- Quiz loading state
- Quiz request failure
- Connection-loss overlay/banner
- Retry controls

The UI should avoid repeatedly blocking the user unnecessarily when connectivity is available.

When the network is unavailable, the user should understand:

1. What happened
2. Why the requested action cannot continue
3. What they can do
4. Whether retrying is appropriate

---

# 11. Existing Backend / Cloudflare Worker

The native app should initially **reuse the existing Cloudflare Worker/backend** wherever its current API contract remains appropriate.

We are not rebuilding the backend merely because the Android client is changing.

Initial sequence:

1. Confirm existing Worker API contract
2. Build native networking layer
3. Connect native repository/data source to Worker
4. Start with a known-good category
5. Test successful response
6. Test malformed/error responses
7. Test timeout/failure
8. Test connection loss
9. Test question behavior
10. Expand to additional categories

Backend replacement or major redesign is a separate future decision.

---

# 12. What Comes From V1

The native project carries forward the product knowledge from the existing React application.

Important reusable knowledge includes:

- Quiz rules
- Scoring behavior
- Question structure
- Category definitions
- API contracts
- Cloudflare Worker knowledge
- Question-provider research
- Anti-repetition requirements
- Connectivity requirements
- AdMob requirements
- Bible requirements
- Licensing considerations
- UI/UX direction
- Commercial planning
- Testing procedures
- Android release/signing knowledge
- Known problems
- Solutions that worked
- Solutions that did not work

The **client implementation** itself will be rewritten rather than mechanically converted.

There is no expectation of a direct React-to-Kotlin conversion.

---

# 13. Quiz Engine

The native quiz engine should preserve important V1 behavior while using a native architecture.

Core requirements:

- Fetch questions online
- Display question
- Display answer options
- Accept answers
- Track score
- Handle question progression
- Handle timer where applicable
- Handle quiz completion
- Display results
- Support categories
- Support difficulty where available
- Maintain question history
- Avoid inappropriate repetition
- Handle network errors
- Handle loading
- Handle empty/error responses

The engine should be designed so that categories/providers do not require rewriting the entire quiz system.

---

# 14. Categories

Current product categories:

1. Science
2. General Knowledge
3. Africa & Nigeria
4. Bible
5. Current Affairs

The existing React application already has working Science and General Knowledge implementations.

Africa & Nigeria, Bible, and Current Affairs are the remaining major categories planned for V1.

The native application can use V1 as its behavioral reference while implementing categories through the new native architecture.

---

# 15. Africa & Nigeria

Planned subject areas include:

- Nigerian history
- Nigerian geography
- African history
- African geography
- Culture
- People and places
- Government/civic knowledge where appropriate
- Other useful African/Nigerian general knowledge

Provider decisions will be based on source quality, coverage, licensing, reliability, freshness, and API behavior.

---

# 16. Bible

Bible functionality is more than a normal quiz category.

The planned product may contain:

### Bible library

- Offline Bible reading
- Local Bible text/resource
- Reading/navigation experience
- Appropriate search/navigation
- Careful licensing

### Bible quiz

- Internet required
- Fresh/generated/retrieved questions
- Question validation
- Scripture references
- Quiz scoring

Current planning direction:

- World English Bible is the leading version under consideration
- Catholic-edition requirements need separate licensing/source verification
- Bible text licensing must be confirmed before final inclusion

The Bible library and Bible quiz should be architecturally separable.

---

# 17. Current Affairs

Current Affairs requires a different data strategy because freshness is fundamental.

Requirements will include:

- Current/recent information
- Reliable source/provider
- Date awareness
- Freshness handling
- Question validation
- Avoiding stale questions
- Clear handling of unavailable/failing sources

The source/provider architecture should allow the category to evolve without changing the entire quiz engine.

---

# 18. Local Storage

Local storage should be introduced only where it solves a real problem.

## Room

Potential use:

- Recent question history
- Anti-repetition records
- Other structured local application data

Room should not become a source of offline quiz questions unless that is deliberately designed later.

## DataStore

Potential use:

- User preferences
- Settings
- Small configuration values
- Lightweight local state

DataStore operations should remain in the data layer/repository and be exposed to UI through ViewModels.

## Bible

The offline Bible library will have its own local resource/storage strategy based on the final text format and licensing decision.

---

# 19. AdMob

The native application will eventually use the native Google Mobile Ads SDK.

V1 AdMob experience remains useful, including:

- App-open ads
- Banner ads
- Quiz-screen banner placement
- Results/category banner placement
- Startup/loading interaction
- Test ad behavior
- Real-ad validation

AdMob will be implemented as its own stage.

We should avoid scattering advertising logic throughout UI screens.

A dedicated advertising layer/service should be considered so ad behavior remains maintainable.

---

# 20. UI/UX Direction

The existing design direction remains:

**Daily Quiz & Challenge — Clean Competitive**

Desired visual characteristics:

- White foundation
- Strong/sharp blue
- One complementary accent
- Clean
- Modern
- Energetic
- Professional
- Strong hierarchy
- Good motion/interaction
- Not childish
- Not overly corporate
- Not gradient-heavy
- Not a generic default Material application

Material 3 can provide foundational components, but the application should have its own visual identity.

---

# 21. Planned UI/UX Areas

The native UI eventually needs to support:

- Startup/loading
- Home
- Categories
- Quiz
- Results
- Bible library
- Bible reading
- Bible quiz
- Current Affairs
- Premium areas
- Settings
- Connectivity states
- Ad placements
- Future account screens
- Future subscription screens

Figma/design-system work will be used at the appropriate UI/UX stage.

The native project should not block technical validation while waiting for the final visual design.

---

# 22. Commercial Architecture

Commercial functionality is planned for later.

Possible future capabilities:

- Premium categories
- Locked content
- Premium subscription
- Recurring subscription options
- Ad-free option
- Premium-only notices
- Entitlements
- Google Play Billing

The exact pricing and commercial model remain future decisions.

The first native stages will not contain billing or subscription code.

---

# 23. Firebase

Firebase is **not an initial requirement**.

Potential future uses:

- Authentication
- Analytics
- Crash reporting
- Remote configuration
- Other product/backend services

Firebase should only be introduced when a concrete requirement exists.

The project should not become dependent on Firebase merely because it is a common Android service.

---

# 24. Authentication and Accounts

Accounts are future functionality.

Potential future requirements:

- User account
- Sign-in
- Subscription entitlement
- Cloud-synced preferences/progress
- Cross-device state

No account system is required for the first native quiz prototype.

---

# 25. Package, Signing, and Migration Strategy

When the native application eventually approaches production replacement/update status, we must verify:

- Android application ID/package name
- Existing signing key/keystore
- Version code
- Version name
- Google Play identity
- Release signing
- Local database/data migration
- Preferences migration
- Existing installation update behavior
- Backup/restore implications
- Deep links if introduced
- Notification/channel migration if introduced

### Important

A native rewrite can potentially become a later update of the same Android application if the necessary identity and signing conditions are preserved.

This will require an explicit test:

**Existing signed V1 → install native release → verify update/data behavior**

We will not assume this works until tested.

---

# 26. Development Stages

## Stage 0 — Planning

Status: **Complete**

- Create repository
- Create roadmap
- Establish native direction
- Establish migration boundaries
- Establish staged workflow

## Stage 1 — Native Android Shell

- Create Kotlin/Compose project
- Establish package/application identity strategy
- Basic Activity
- Basic Compose screen
- Theme foundation
- Build APK
- Install on device
- Test

## Stage 2 — UI Foundation

- Compose theme
- Typography
- Spacing
- Shapes
- Colors
- Reusable components
- Navigation foundation
- Loading state
- Error state
- Connectivity UI foundation

## Stage 3 — Quiz Engine

- Question model
- Quiz state
- Answer selection
- Scoring
- Timer where required
- Results
- Local test questions
- Device test

## Stage 4 — Network Layer

- HTTP client
- Remote data source
- Repository
- Cloudflare Worker
- General Knowledge
- Loading/error behavior
- Connectivity testing

## Stage 5 — Question History

- Local persistence
- Recent history
- Anti-repetition
- Verify history is not an offline question source

## Stage 6 — Category Expansion

Migrate/test incrementally:

- Science
- General Knowledge
- Africa & Nigeria
- Bible
- Current Affairs

The order can change if technical dependencies require it.

## Stage 7 — Native AdMob

- Test ads
- App-open
- Banners
- Placement
- Startup/loading behavior
- Real-ad validation later

## Stage 8 — Major UI/UX

- Figma
- Design system
- Final visual direction
- Adaptive layouts
- Animation
- Accessibility
- Polish

## Stage 9 — Supporting Infrastructure

Only when required:

- Firebase
- Authentication
- Analytics
- Crash reporting
- Remote configuration
- Other infrastructure

## Stage 10 — Commercial System

- Premium architecture
- Entitlements
- Subscription products
- Ad-free product
- Google Play Billing
- Premium UI

## Stage 11 — V1 → Native Transition

- Behavioral comparison
- Regression testing
- Package/signing verification
- Data migration
- Update testing
- Release preparation

---

# 27. Testing Strategy

Testing must happen continuously.

### Every major feature

1. Build
2. Install
3. Test normal behavior
4. Test error behavior
5. Test network behavior
6. Test device/back navigation behavior
7. Check UI
8. Fix
9. Commit
10. Document

### Device testing

At minimum, the application should be tested on a real Android phone throughout development.

Later testing should include additional screen sizes where practical.

---

# 28. Performance and Quality

Native does not automatically mean high quality.

We will deliberately test:

- Startup time
- UI responsiveness
- Recomposition behavior
- Network loading
- Memory use
- Scrolling
- Animations
- Ad behavior
- Database behavior
- Large-screen/adaptive layouts
- Accessibility
- Error handling

Compose performance guidance should be followed, including avoiding unnecessary recompositions and expensive work inside composables.

Baseline/profile optimization can be considered later when the app has enough real UI to benefit from it.

---

# 29. Security and Secrets

Secrets must not be committed to GitHub.

Examples:

- API keys
- Private tokens
- AdMob-sensitive configuration where applicable
- Firebase configuration/secrets requiring protection
- Backend credentials

Public/client-side configuration must be distinguished from actual secrets.

The existing Worker should remain the preferred boundary for sensitive server-side credentials.

---

# 30. GitHub and Version Control

The repository will use GitHub as the source of truth for the native project.

Important practices:

- Small logical commits
- Clear commit messages
- Checkpoint commits after milestones
- Documentation updated with major decisions
- No unnecessary rewrites of project history
- Feature branches only when they provide a real benefit
- Keep main branch buildable where practical

---

# 31. Relationship With the Existing React Project

The React project remains active.

The immediate V1 sequence is:

1. Continue existing project
2. Add remaining categories
3. Test/stabilize
4. Continue product development

The native repository develops independently until we deliberately begin Stage 1.

This separation protects the working React application while allowing native experimentation.

---

# 32. Migration: What Can Be Reused

### Can be reused conceptually

- Product requirements
- Question rules
- Category definitions
- Backend contracts
- API/provider research
- Worker behavior
- Business requirements
- UI/UX decisions
- Bible requirements
- Testing knowledge
- Ad requirements
- Release knowledge

### May be reusable as data/configuration

- API endpoint definitions
- Category configuration
- Question-provider configuration
- Some static assets
- Documentation
- Legal/licensing records

### Will generally be reimplemented

- React components
- JSX
- CSS
- Capacitor plugins
- JavaScript client-side state
- React-specific navigation
- React-specific AdMob implementation
- Browser/WebView-specific code

The native app is therefore a **reimplementation using the same product knowledge**, not a literal source-code conversion.

---

# 33. What We Are Deliberately NOT Building Yet

At the beginning:

- No Firebase
- No authentication
- No accounts
- No subscriptions
- No Google Play Billing
- No complete premium system
- No iOS app
- No backend replacement
- No full production advertising system
- No requirement to migrate every feature immediately
- No attempt to build the whole product in one milestone

The first objective is to prove the native Android foundation.

---

# 34. Future iOS Direction

iOS is a future consideration.

Nothing in the current Android repository requires us to build iOS now.

When the product and Android architecture are mature, an iOS strategy can be evaluated separately.

Possible future approaches can then be compared based on actual requirements rather than prematurely constraining the Android architecture.

---

# 35. Decision Log

### Decision 001 — Separate native repository

The native Android implementation uses:

`daily-quiz-android`

This keeps it separate from the existing React/Capacitor repository.

### Decision 002 — Kotlin + Jetpack Compose

The native Android implementation will use Kotlin and Jetpack Compose.

### Decision 003 — Existing V1 remains active

The React/Capacitor application continues to be developed.

### Decision 004 — Reuse the existing Worker initially

The native app should initially connect to the existing Cloudflare Worker where the API contract remains suitable.

### Decision 005 — Incremental development

The native app will be built stage by stage.

### Decision 006 — No all-at-once architecture

Firebase, commercial systems, authentication, billing, and other future infrastructure are not prerequisites for the first native implementation.

### Decision 007 — Native Android first

The immediate native target is Android. iOS can be planned later.

### Decision 008 — V1 is the reference implementation

The existing app provides working behavior, product knowledge, and lessons for the native implementation.

---

# 36. Current Research Checkpoint — Android Stack

Current Android/Google documentation confirms the direction of this roadmap:

- Jetpack Compose is Google's preferred Android UI toolkit.
- Compose is well suited to adaptive/responsive layouts.
- Modern Compose-only applications can use a single Activity with screen-level composables and Compose navigation.
- Android guidance emphasizes state-driven UI and ViewModels/data-layer separation.
- DataStore is intended for lightweight persisted state, while Room is more appropriate for larger/complex structured datasets.
- Android 15+ requires careful edge-to-edge/inset handling.
- Android 16 increases the importance of adaptive layouts and state preservation across changing window sizes.
- Navigation 3 is part of the current Compose-first navigation ecosystem, but the project will choose the appropriate stable navigation approach at implementation time rather than blindly adopting the newest API.

These decisions should be revisited when Stage 1 begins because AndroidX libraries continue to evolve.

---

# 37. First Implementation Scope

When we officially begin coding this repository, **Stage 1 is intentionally small**.

The first native milestone should be:

- Kotlin project
- Compose enabled
- One Activity
- Basic app theme
- One initial screen
- Correct package/application setup
- Buildable debug APK
- Installable on the test Android device
- Basic Git checkpoint

Only after that works do we proceed to the next stage.

---

# 38. Current Checkpoint

**Repository:** `daily-quiz-android`

**Roadmap:** Created

**Native implementation:** Not started

**Current stage:** Stage 0 — Planning

**Next native stage:** Stage 1 — Native Android Shell

**Current V1 work:** Continue separately in `daily-quiz-challenge`

---

# 39. Documentation Rule

This file is the native project's master continuity document.

Update it when there is a meaningful:

- Architecture decision
- Product decision
- Migration decision
- UI/UX decision
- Backend decision
- Category decision
- Ad decision
- Commercial decision
- Testing milestone
- Release milestone
- Known issue
- Important lesson

Do not turn this into an enormous daily diary.

Record important decisions and milestones clearly enough that development can continue later without relying on chat history.
